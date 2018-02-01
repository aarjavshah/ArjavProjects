import urllib2
from BeautifulSoup import BeautifulSoup, SoupStrainer
res = urllib2.urlopen('http://www.moneycontrol.com/india/stockpricequote/computers-software/infosys/IT')
#print res.read()
file = open('sample.txt','w')
file.write(res.read())
file.close()
file =open('sample.txt','r')
for link in BeautifulSoup(response, parseOnlyThese=SoupStrainer('div')):
    if link.has_attr('id'):
        print link['href']
print 'ALL DONE'