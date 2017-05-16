# import re
# string = 'SET OutputLocalEnvironment.Destination.MQ.DestinationData[300].queueName = Replace(SHADOW_QUEUE_NAME_PATTERN,\'*\',Country);'
# tmp = 'OutputLocalEnvironment.Destination.MQ.DestinationData\['
# pattern = re.compile('OutputLocalEnvironment.Destination.MQ.DestinationData\[')
# x = pattern.match(string.strip().lower())
# if x:	
	# print x.span()
# else:
	# print 'No match'
# i=0
#while i<7:	
# print re.compile(tmp.lower()).search(string.strip().lower()).group()
#	i +=1


#import NodeNames
#NodeNames.RemoveDuplicateNodeNames('D:\\OneClickMig\\MigratedData\\IXML\\IXMLProcessing\\IXMLAggregator.msgflow','D:\\OneClickMig\\MigratedData\\IXML\\IXMLProcessing\\tmp.msgflow')


line = '		SET          I=0;'
varN = 'I'
if (line.strip().split(' ')[1]==varN or line.strip().split(' ')[1]==varN+'=' or line.strip().split(' ')[1].split('=')[0]==varN):
	print 'True'
else:
	print 'False'

if line.strip().split('=')[0].strip().endswith(' '+varN):
	print 'True'
else:
	print 'False'