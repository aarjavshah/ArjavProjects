def updateFileSet(num,module,chLine):
	i=0
	moduleUpdated = ''
	for line in module.split('\n'):
		#print line
		if i==num:
			line = chLine
		moduleUpdated = moduleUpdated+line+'\n'
		i+=1
	return moduleUpdated

def printCorrection(src):
	print 'correcting file '+src