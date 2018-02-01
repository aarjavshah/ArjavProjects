class StockVO:
	def __init__(self,name,bseVal,nseVal):
		self.name = name
		self.bseVal = bseVal
		self.nseVal = nseVal
	def getName(self):
		return self.name
	def getBseVal(self):
		return self.bseVal
	def getNseVal(self):
		return self.nseVal