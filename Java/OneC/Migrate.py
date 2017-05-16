import sys, getopt,logging
import os,shutil
import CheckNodeNames,CheckArraySubscript,ArraySubscript,NodeNames,CheckNodeType
import subprocess as sp

def main(argv):
	src = ''
	dest = ''
	FlagS = False
	FlagD = False
	try:
		opts, args = getopt.getopt(argv,"hi:o:",["ifile=","ofile="])
	except getopt.GetoptError:
		print 'test.py -i <source path> -o <destination path>'
		sys.exit(2)
	for opt, arg in opts:
		if opt == '-h':
			print 'test.py -i <source path> -o <destination path>'
			sys.exit()
		elif opt in ("-i", "--ifile"):
			src = arg
			FlagS = True
			#print 'x'
		elif opt in ("-o", "--ofile"):
			dest = arg
			FlagD = True
			#print 'y'
	if not(FlagS and FlagD):
		print 'Error in Syntax\ntest.py -i <source path> -o <destination path>'
	else:
		print 'Source Directory is ', src
		print 'Destination Directory is ', dest
		
	try:
		shutil.copytree(src, dest)
	except shutil.Error as e:
		print('Directory not copied. Error: %s' % e)
	except OSError as e:
		print('Directory not copied. Error: %s' % e)
	LOG_FILE = os.path.join(dest,'AutoMigrationLogs.log')
	RPT_FILE = os.path.join(dest,'Report.txt')
	
	FORMAT = "%(asctime)s - %(message)s"
	logging.basicConfig(filename=LOG_FILE,level=logging.DEBUG,format=FORMAT)
	logger = logging.getLogger('My Logger')		
	logger.debug("Starting Workspace Migration From WMB v6 to IIB v10.")	
	ReportFile = open(RPT_FILE,'w')
	ReportFile.write('--------------------------------------\nANALYSIS REPORT OF EXISTING WORKSPACE.\n--------------------------------------\n\n')
	ReportFile.close()
	for path,dir,files in os.walk(dest):
		for file in files:
			print 'checking file '+os.path.join(path,file)
			if file.endswith(".msgflow"):
				CheckNodeNames.CheckDuplicateNodeNames(os.path.join(path,file),RPT_FILE,LOG_FILE)
				CheckNodeType.CheckDepNodes(os.path.join(path,file),RPT_FILE,LOG_FILE)
			elif file.endswith(".esql"):
				CheckArraySubscript.SubscriptDetector(os.path.join(path,file),RPT_FILE,LOG_FILE)
	
	print '\n\nMigration Analysis completed. Check the Generated Report in '+RPT_FILE+'\n\n'
	ReportFile = open(RPT_FILE,'a')
	ReportFile.write('\n\n\nIn case of Duplicate Node names a postfix will be attached to the name to fix the issue.\nIn case of Array Index correction earliest SET statement or the Declaration Statement will be changed.\nHowever Deprecated Nodes must be replaced with suitable node MANUALLY.')
	ReportFile.close()
	programName = "notepad.exe"
	fileName = RPT_FILE
	sp.Popen([programName, fileName])
	selector = raw_input('''The Changes for the Duplicate Node names and Array Index can be corrected Automatically. However Deprecated Nodes must be replaced with suitable node MANUALLY.\n
In case of Duplicate Node names a postfix will be attached to the name to fix the issue.
In case of Array Index correction earliest SET statement or the Declaration Statement will be changed.
Do you wish to continue with Automatic correction?(Y/N)''')
	#print selector
	print'\n\n'
	if selector.strip().lower() == 'y':
		for path,dir,files in os.walk(dest):
			for file in files:
				#print 'checking file '+os.path.join(path,file)
				if file.endswith(".msgflow"):
					NodeNames.RemoveDuplicateNodeNames(os.path.join(path,file),os.path.join(path,'tmp.msgflow'),LOG_FILE)
				elif file.endswith(".esql"):
					ArraySubscript.SubscriptCorrector(os.path.join(path,file),os.path.join(path,'tmp.esql'),LOG_FILE)
	
		print '\n\nMigration Task completed. Check the updated workspace at '+dest+'\n\n'

if __name__ == "__main__":
	main(sys.argv[1:])