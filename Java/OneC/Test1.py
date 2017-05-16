import xml.etree.ElementTree as ET
import os,logging
DepList = ['DataDelete','DataInsert','Warehouse','DataUpdate','DatabaseRoute','Extract','PhpCompute','MQOptimizedFlow']
tree = ET.parse("D:\\A.txt")#BrokerFlowProjects\\ACXI_EG\\AcxiomGSRLtoADP_BE.msgflow")
root = tree.getroot()
eClassifier = root.find('eClassifiers')
composition = eClassifier.find('composition')
for nodes in composition.findall('nodes'):
	nodeType = nodes.get('{http://www.omg.org/XMI}type')
	tmp = nodeType.split('.')[0]
	#print tmp[6:]
	if tmp[6:] in DepList:
		print 'Yes'
	else:
		print 'No'