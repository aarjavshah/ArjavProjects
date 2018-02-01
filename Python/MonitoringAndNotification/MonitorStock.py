import urllib2
from bs4 import BeautifulSoup
from StockVO import StockVO
def GetValues(reqUrl):
	res = urllib2.urlopen(reqUrl)
	resStr = res.read()
	if resStr.strip() == '':
		return None
	else:
		soup = BeautifulSoup(resStr, 'html.parser')
		#perc = soup.find(id="b_changetext")#enhancement for % change
		try:
			x = StockVO(soup.h1.string, soup.find(id="Bse_Prc_tick_div").string, soup.find(id="Nse_Prc_tick_div").string)
			return x
		except AttributeError:
			return None