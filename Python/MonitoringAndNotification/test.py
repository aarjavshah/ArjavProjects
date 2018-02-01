import datetime,time
#_4pm = now.replace(hour=16, minute=00, second=0, microsecond=0)
isStart = False
now = datetime.datetime.now()
_915am = now.replace(hour=1, minute=40, second=0, microsecond=0)
_9am = now.replace(hour=1, minute=41, second=0, microsecond=0)
_4pm = now.replace(hour=16, minute=00, second=0, microsecond=0)
if now>_4pm:
	delta = now-_4pm
	time.sleep(delta.seconds)
elif now<_915am:
	delta = _915am-now
	time.sleep(delta.seconds)
print 'arjav'
while not isStart:
	now = datetime.datetime.now()
	if now>_9am:
		isStart = True
	else:
		time.sleep(1)
if isStart :
	print 'Starting'