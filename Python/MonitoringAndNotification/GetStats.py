import matplotlib.pyplot as plt

def plotGraph(vals,name):
	plt.plot(vals)
	plt.ylabel('Rate(Rs.)')
	plt.savefig(name)
	#plt.show()