import re,commonFunc,os,logging

def SubscriptDetector(src,rpt,log):
	pathIn = src
	#pathOut = temp
	pathReport = rpt
	LOG_FILE = log
	FORMAT = "%(asctime)s - %(message)s"
	logging.basicConfig(filename=LOG_FILE,level=logging.DEBUG,format=FORMAT)
	logger = logging.getLogger('My Logger')	
	fileIn = open(pathIn,'r')
	#fileOut = open(pathOut,'w')
	fileRpt = open(pathReport,'a')
	moduleList = list()
	moduleListUpdated = list()
	arrayVariables = list()
	i=0
	j=0
	module = ''
	flag = False
	flagSpace = False
	modCount = 0
	decl = ''
	for line in fileIn:
		i+=1
		#if line.strip().startswith('--'):
			#print 'Comment: '+line
		#	pass
		#else:
		
		pattern = re.compile('create (.*) module')
		x = pattern.match(line.strip().lower())
		if x and not(line.strip().startswith('--')):
			modCount += 1
			if modCount>1:
				moduleList.append(module)
				module ='' 
				modFirst = False
			j+=1
			#print 'start of module '+str(j)+' at line '+str(i)
			
			flag = True
			flagSpace = False
		if flag or flagSpace:
			module = module+line
		if line.strip().lower().startswith('end module;'):
			flag = False
			flagSpace = True
		
		if modCount == 0:
			decl = decl + line
	moduleList.append(module)		
	j = 0
	#print moduleList
	for module in moduleList:
		SetDetFlag = False
		#print module
		arrayVariables = list()
		moduleUpdated = module
		moduleTmp = ''
		j+=1
		#print 'Opening module '+str(j)
		flag = False
		i=0
		for line in module.split('\n'):
			i+=1
			if line.strip().startswith('--'):
				#print 'Comment: '+line
				pass
			else:
				if '[' in line and ']' in line and 'CARDINALITY' not in line:
					#print '\tArray Subscript Detected: '+line.strip()
					x = u''+line[line.find('[')+1:line.find(']')]
					if x.isnumeric():
						if int(float(x))==0:
							pre = line[:line.find('[')]
							fileRpt.write('In '+src+', Problem in Array Index at '+pre.strip()+'[]\n')
							#print '\t\tProblem in '+ line.strip()
							
							# post = line[line.find(']')+1:]
							# tmp = pre[pre.rfind(' ')+1:] + '\[(.*)\]'+ post[:post.find(' ')]
							# #print tmp
							# pattern = re.compile(tmp.lower())
							# #print moduleUpdated
							# for line1 in moduleUpdated.split('\n'):
								# #print line1
								# a = pattern.search(line1.strip().lower())
								# #print a
								# if a:
									# #print line1
									# y = u''+line1[line1.find('[')+1:line1.find(']')]
									# z = int(float(y))+1
									# line1 = line1[:line1.find('[')+1]+str(z)+line1[line1.find(']'):]
									# logger.debug("In "+src+" Array Subscript 0 detected as numeric value detected. Correcting subscript for all instaces of same elements.")
								# moduleTmp = moduleTmp + line1 + '\n'
							# moduleUpdated =moduleTmp						
							#print moduleUpdated
					else:
						#print x
						arrayVariables.append(x+'@'+str(i))
				else:
					#print line
					pass
				
		#print arrayVariables
		#moduleTmp = moduleUpdated
		for indVar in arrayVariables:
			moduleTmp = ''
			#print indVar
			varN = indVar.split('@')[0]
			lineN = indVar.split('@')[1]
			
			#print indVar.split('@')[1]
			
			lines = moduleUpdated.split('\n')
			k=int(float(lineN))-1
			#print k
			flagDec = False
			while k>=0:
				k-=1
				line = lines[k]
				#print line
				if line.strip().lower().startswith('set') and line.strip().split('=')[0].strip().endswith(' '+varN) and line.strip().split('=')[1].strip().split(';')[0].strip()=='0':
					#print '\tEarliest SET statement detected:\n\t'+line.strip()
					#print 'problem in set'
					#print 'correcting....'
					if line.strip().split(' ')[1]==varN and (int(float(line.strip().split(' ')[3].split(';')[0]))==0 or line.strip().split(' ')[3]=='0;'):
						# buildLine = line.strip().split(' ')
						# chLine = line.lower().split('s')[0]+buildLine[0]+' '+buildLine[1]+' '+buildLine[2]+' 1;'
						# moduleUpdated = commonFunc.updateFileSet(k,moduleUpdated,chLine)
						fileRpt.write('In '+src+' SET statement setting Index variable to 0 was found.\n')
					elif line.strip().split(' ')[1]==varN+'=' and (int(float(line.strip().split(' ')[2].split(';')[0]))==0 or line.strip().split(' ')[2]=='0;'):
						# buildLine = line.strip().split(' ')
						# chLine = line.lower().split('s')[0]+buildLine[0]+' '+buildLine[1]+' 1;'
						# moduleUpdated = commonFunc.updateFileSet(k,moduleUpdated,chLine)
						fileRpt.write('In '+src+' SET statement setting Index variable to 0 was found.\n')
					elif line.strip().split(' ')[1].split('=')[0]==varN and (int(float(line.strip().split(' ')[1].split('=')[1].split(';')[0]))==0 or line.strip().split(' ')[1]==varN+'=0;') :
						# buildLine = line.strip().split(' ')
						# chLine = line.lower().split('s')[0]+buildLine[0]+' '+buildLine[1].split('=')[0]+'='+'1;'
						# moduleUpdated = commonFunc.updateFileSet(k,moduleUpdated,chLine)
						fileRpt.write('In '+src+' SET statement setting Index variable to 0 was found.\n')
					SetDetFlag = True
					break
				if k==0:
					pass
					#print '\tno set statement'
			if not(SetDetFlag):
				for line in moduleUpdated.split('\n'):	
				#print line
					#if 'DECLARE '+indVar+' ' in line.strip() or 'SET '+indVar+ ' ' in line.strip() or 'SET '+indVar+ '=' in line.strip() or 'declare '+indVar+' ' in line.strip() or 'set '+indVar+ ' ' in line.strip() or 'set '+indVar+ '=' in line.strip():
					#CHECK FOR DECLARE STATEMENTS IN THAT MODULE
					if line.strip().lower().startswith('declare'):
						count = 0
						flag = False
						for word in line.strip().split(' '):
							count += 1
							if flag:
								if (count == 4):
									initVal = int(float(word.split(';')[0]))
									if initVal == 0:
										#print 'intial value problem in declaration at '+line.strip()
										# l = line.strip().split(' ')
										# if line.strip().startswith('D'):
											# leadSpace = line.split('D')
										# elif line.strip().startswith('d'):
											# leadSpace = line.split('d')
										# tmp = leadSpace[0] + l[0] + ' ' + l[1] + ' ' + l[2] + ' ' + str(1) + ';'
										fileRpt.write('In '+src+' Declaration statement intialized with 0 for Index variable was found.\n')
										#line = tmp
							if count == 2 and word==varN:
								#print '\t\t'+line.strip()
								flag = True
								
					#moduleTmp = moduleTmp +line+'\n'
				#moduleUpdated = moduleTmp
		#print moduleUpdated
		#moduleListUpdated.append(moduleUpdated)
	#fileOut.write(decl)
	#for module in moduleListUpdated:
		#fileOut.write(module)
		
	fileIn.close()
	fileRpt.close()
	#fileOut.close()
	#os.remove(src)
	#os.rename(temp,src)
	#print 'ALL DONE\n\n\n\n\n\n\n\n\n\n\n\n\n'


