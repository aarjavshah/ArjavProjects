import xml.etree.ElementTree as ET
import os,logging

def CheckDuplicateNodeNames(src,rpt,log):
	LOG_FILE = log
	RPT_FILE = rpt
	FORMAT = "%(asctime)s - %(message)s"
	logging.basicConfig(filename=LOG_FILE,level=logging.DEBUG,format=FORMAT)
	logger = logging.getLogger('My Logger')
	nodenames = list()
	corL = list()
	pathIn = src
	#pathOut = temp
	flag = True
	fileRpt = open(RPT_FILE,'a')
	tree = ET.parse(pathIn)
	root = tree.getroot()
	eClassifier = root.find('eClassifiers')
	composition = eClassifier.find('composition')
	for nodes in composition.findall('nodes'):
		nodename = nodes.find('translation').get('string')
		#print nodename;
		i = 0
		flag1 = False
		for tmp in nodenames:
			i+=1
			if tmp==nodename:
				flag1 = True
				fileRpt.write('In '+src+' Duplicate NodeNames were detected.(NodeName:'+nodename+')\n')
				#print 'In '+src+' Duplicate NodeNames were detected.(NodeName:'+nodename+')'
		
		if not(flag1):
			nodenames.append(nodename)
		if flag:
			nodenames.append(nodename)
			flag = False
	
	#print nodenames
	#for x in nodenames:
	#	print x
	#file = open(pathIn,'r')
	
	#file1 = open(pathOut,'w')
	# flag = False
	# i = 0
	# for line in file:
		
		# if flag:
			# line = line[:line.find('string=\"')+8] + nodenames[i]+'\"/>\n'
			# #print line
			# flag = False
			# i+=1
		
		# if line.strip().startswith('<nodes'):
			# flag = True
		
		# file1.write(line)
	
	#file.close()
	fileRpt.close()
	#file1.close()
	# os.remove(src)
	# os.rename(temp,src)
	#print 'ALL DONE'