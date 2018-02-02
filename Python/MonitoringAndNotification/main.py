import MonitorStock
import mailTest
from StockVO import StockVO
import time
import datetime,GetStats
j=0
while True:
	today = datetime.datetime.today().weekday()
	if today>=0 and today<=4:
		now = datetime.datetime.now()
		_915am = now.replace(hour=9, minute=15, second=0, microsecond=0)
		_9am = now.replace(hour=9, minute=30, second=0, microsecond=0)
		_4pm = now.replace(hour=16, minute=00, second=0, microsecond=0)
		_12am = now.replace(hour=23, minute=59, second=59, microsecond=0)
		isStart =False
		isStop =False
		if now>_4pm:
			delta = _12am-now
			time.sleep(delta.seconds+33301)
		elif now<_915am:
			delta = _915am-now
			time.sleep(delta.seconds)

		while not isStart:
			nowN = datetime.datetime.now()
			if nowN>_9am:
				isStart = True
			else:
				time.sleep(1)
		if isStart:
			isStart = False
			print 'Day %s Started'%j
			i=0
			infy=[]
			pfc=[]
			tcs=[]
			wipro=[]
			colpal=[]
			while i<25:
				i = i+1
				strt = time.time()
				urlList = open('links.lst','r')
				messageBody = ''
				j=0
				for line in urlList:
					j=j+1
					stk = MonitorStock.GetValues(line)
					if stk == None:
						print 'Error in getiing the data'
					else:
						if j==1:
							infy.append(stk.nseVal)
						elif j==2:
							pfc.append(stk.nseVal)
						elif j==3:
							tcs.append(stk.nseVal)
						elif j==4:
							wipro.append(stk.nseVal)
						elif j==3:
							colpal.append(stk.nseVal)
						#print '%s'%stk.name
						#print '\t%s'%stk.bseVal
						#print '\t%s'%stk.nseVal
						messageBody = messageBody+stk.name+'\n\t'+stk.bseVal+'\n\t'+stk.nseVal+'\n'
				print messageBody
				messageBody = messageBody+'''\nHappy Trading.\n
				AutoGenerated From Ample Stock Monitor Service.'''
				mailTest.sendEmail(messageBody)
				urlList.close()
				print 'EMail No.%s Sent!'%i
				timeEcl = (time.time()-strt)
				print '---%s---'%timeEcl
				time.sleep(900-timeEcl)

			GetStats.plotGraph(infy,'infy.png')
			mailTest.sendEmailAttach('Infosys','infy.png')
			GetStats.plotGraph(pfc,'pfc.png')
			mailTest.sendEmailAttach('Power Finance','pfc.png')
			GetStats.plotGraph(tcs,'tcs.png')
			mailTest.sendEmailAttach('TCS','tcs.png')
			GetStats.plotGraph(wipro,'wipro.png')
			mailTest.sendEmailAttach('Wipro','wipro.png')
			GetStats.plotGraph(colpal,'colpal.png')
			mailTest.sendEmailAttach('Colgate','colpal.png')

			txt='''Testing Successful
			Congratulations!'''
			mailTest.sendEmail(txt)
			
		while not isStop:
			nowN = datetime.datetime.now()
			if nowN>_4pm:
				isStop = True
			else:
				time.sleep(1)
		if isStop:
			isStop = False
			time.sleep(62100)
	elif today==5:
		now = datetime.datetime.now()
		_12am = now.replace(hour=23, minute=59, second=59, microsecond=0)
		delta = _12am-now
		time.sleep(delta.seconds+33301+86400)
	elif today==6:
		now = datetime.datetime.now()
		_12am = now.replace(hour=23, minute=59, second=59, microsecond=0)
		delta = _12am-now
		time.sleep(delta.seconds+33301)		