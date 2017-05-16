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