import xml.etree.ElementTree as ET
import os,logging

def RemoveDuplicateNodeNames(src,temp,log):
	LOG_FILE = log
	FORMAT = "%(asctime)s - %(message)s"
	logging.basicConfig(filename=LOG_FILE,level=logging.DEBUG,format=FORMAT)
	logger = logging.getLogger('My Logger')
	nodenames = list()
	corL = list()
	pathIn = src
	pathOut = temp
	tree = ET.parse(pathIn)
	root = tree.getroot()
	eClassifier = root.find('eClassifiers')
	composition = eClassifier.find('composition')
	for nodes in composition.findall('nodes'):
		nodename = nodes.find('translation').get('string')
		#print nodename;
		i = 0
		for tmp in nodenames:
			i+=1
			if tmp==nodename:
				nodename = nodename +'2'
				tmp = tmp+'1'
				nodenames[i-1]=tmp
				logger.debug("In "+src+" Duplicate Node Names detected. Adding the PostFix to all duplicateNodes.")
		nodenames.append(nodename)
		
	#for x in nodenames:
	#	print x
	file = open(pathIn,'r')
	file1 = open(pathOut,'w')
	flag = False
	i = 0
	for line in file:
		
		if flag:
			line = line[:line.find('string=\"')+8] + nodenames[i]+'\"/>\n'
			#print line
			flag = False
			i+=1
		
		if line.strip().startswith('<nodes'):
			flag = True
		
		file1.write(line)
	
	file.close()
	file1.close()
	os.remove(src)
	os.rename(temp,src)
	#print 'ALL DONE'