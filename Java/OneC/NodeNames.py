import xml.etree.ElementTree as ET
import os,logging,commonFunc

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
		i=len(nodenames)-1
		while i>=0:
			j = 0
			if nodenames[i] == nodename:
				j = 0
				flag = False
				while j<len(corL):
					val=corL[j]
					#print str(j)+''+val
					if val.split('@')[0]==nodename:
						postfix = int(float(val.split('@')[1]))+1
						corL[j] = nodename+'@'+str(postfix)
						#print corL
						nodename = nodename + str(postfix)
						logger.debug("In "+src+" Duplicate Node Names detected. Adding the PostFix to all duplicateNodes.")
						commonFunc.printCorrection(src)
						flag = True
					else:
						pass
					j=j+1
				if not(flag):
					postfix = 1
					corL.append(nodename+'@'+str(postfix))
					nodename = nodename + str(postfix)
					logger.debug("In "+src+" Duplicate Node Names detected. Adding the PostFix to all duplicateNodes.")
					commonFunc.printCorrection(src)
					flag = True
				if len(corL)==0:
					flag = False
					postfix = 1
					corL.append(nodename+'@'+str(postfix))
					nodename = nodename + str(postfix)
					logger.debug("In "+src+" Duplicate Node Names detected. Adding the PostFix to all duplicateNodes.")
					commonFunc.printCorrection(src)
			i=i-1
		nodenames.append(nodename)
	#print nodenames
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