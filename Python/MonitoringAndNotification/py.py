import urllib2
from bs4 import BeautifulSoup
res = urllib2.urlopen('http://www.moneycontrol.com/india/stockpricequote/computers-software/infosys/IT')
x = res.read()

#soup = BeautifulSoup(res, 'html.parser')
#print soup.h1.string
#print'\t%s'%soup.find(id="Bse_Prc_tick_div").string
#print'\t%s'%soup.find(id="Nse_Prc_tick_div").string
if x.strip() == '':
	print 'Arjav'
else:
	print 'Shah'
	soup = BeautifulSoup(x, 'html.parser')
	
	print soup.find("h1")#.h1.string
	