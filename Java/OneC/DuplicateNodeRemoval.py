import xml.etree.ElementTree as ET
nodenames = list()
pathIn = 'D:\\BrokerFlowProjects\\IXML\\IXMLProcessing\\IXMLAggregator.msgflow'
pathOut = 'D:\\OneClickMig\\Output\\IXMLAggregator.msgflow'
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
		
print 'ALL DONE'