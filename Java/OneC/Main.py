import os,shutil,logging
import NodeNames,ArraySubscript
src = 'D:\\BrokerFlowProjects'
dest = 'D:\\OneClickMig\\MigratedData'
LOG_FILE = 'D:\\OneClickMig\\MigrationLog.log'

FORMAT = "%(asctime)s - %(message)s"
logging.basicConfig(filename=LOG_FILE,level=logging.DEBUG,format=FORMAT)
logger = logging.getLogger('My Logger')
logger.debug("Starting Workspace Migration From WMB v6 to IIB v10.")
try:
	shutil.copytree(src, dest)
except shutil.Error as e:
	print('Directory not copied. Error: %s' % e)
except OSError as e:
	print('Directory not copied. Error: %s' % e)
for path,dir,files in os.walk(dest):
	for file in files:
		print 'checking file '+os.path.join(path,file)
		if file.endswith(".msgflow"):
			NodeNames.RemoveDuplicateNodeNames(os.path.join(path,file),os.path.join(path,'tmp.msgflow'))
		elif file.endswith(".esql"):
			ArraySubscript.SubscriptCorrector(os.path.join(path,file),os.path.join(path,'tmp.esql'))
			
print 'ALL DONE\n\n\n'
			#file1 = open(os.path.join(path,file),"r")