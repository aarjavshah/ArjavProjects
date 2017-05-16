import xml.etree.ElementTree as ET
import os,logging

def CheckDepNodes(src,rpt,log):
	DepList = ['DataDelete','DataInsert','Warehouse','DataUpdate','DatabaseRoute','Extract','PhpCompute','MQOptimizedFlow']
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
		#print nodeType
		nodeType = nodes.get('{http://www.omg.org/XMI}type')
		tmp = nodeType.split('.')[0]
		#print tmp[6:]
		if tmp[6:] in DepList:
			fileRpt.write('In '+src+' Deprecated Node '+tmp+' was found.\n')
	
	fileRpt.close()