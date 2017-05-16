arrayVariables = list()
loops = list()
pathIn = 'D:\\BrokerFlowProjects\\IXML\\IXMLProcessing\\IXMLAggregator1.esql'
pathOut = 'D:\\OneClickMig\\Output\\IXMLAggregator.esql'
fileIn = open(pathIn,'r')
fileOut = open(pathOut,'w')
i = 0

for line in fileIn:
	i += 1
	fileOut.write(line+'\n')
	if line.strip().startswith('--'):
		#print 'Comment: '+line
		pass
	else:
		if 'while' in line.lower():
			print '-------------------------'+line
			loops.append()
		elif 'loop' in line.lower():
			if '[' in line and ']' in line and 'CARDINALITY' not in line:
				print 'Brackets Detected: '+line.strip()
				x = u''+line[line.find('[')+1:line.find(']')]
				if x.isnumeric():
					if int(float(x))==0:
						print 'Problem in '+ line
				else:
					print x
					arrayVariables.append(x)
			else:
				#print line
				pass
				
fileIn = open(pathIn,'r')
for indVar in arrayVariables:
	#print indVar
	for line in fileIn:	
		#print line
		if 'DECLARE '+indVar+' ' in line.strip() or 'SET '+indVar+ ' ' in line.strip() or 'SET '+indVar+ '=' in line.strip():
			print line

print 'ALL DONE'