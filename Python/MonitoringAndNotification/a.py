import GetStats,mailTest
import matplotlib.pyplot as plt
infy = []
infy.append(1058.05)
infy.append(1059.10)
infy.append(1059.95)
infy.append(1058.75)
infy.append(1055.35)
infy.append(1057.80)
infy.append(1056.95)
infy.append(1059.05)
infy.append(1062.05)
infy.append(1060.05)
infy.append(1056.65)
infy.append(1058.17)
GetStats.plotGraph(infy,'infy.png')

wip = []
wip.append(558.05)
wip.append(559.10)
wip.append(559.95)
wip.append(558.75)
wip.append(555.35)
wip.append(557.80)
wip.append(556.95)
wip.append(559.05)
wip.append(562.05)
wip.append(560.05)
wip.append(556.65)
wip.append(558.17)
GetStats.plotGraph(wip,'wip.png')
#mailTest.sendEmailAttach('Infosys','infy.png')