import smtplib
from email.MIMEMultipart import MIMEMultipart
from email.MIMEText import MIMEText
from email.MIMEBase import MIMEBase
from email import encoders

def sendEmail(message):
	fromaddr = "abc@gmail.com"
	toaddr = "xyz@gmail.com"
	msg = MIMEMultipart()
	msg['From'] = fromaddr
	msg['To'] = toaddr
	msg['Subject'] = "StockUpdates"
	 
	body = message
	msg.attach(MIMEText(body, 'plain'))
	
	
	server = smtplib.SMTP('smtp.gmail.com', 587)
	server.starttls()
	server.login("abc@gmail.com", "abc")
	text = msg.as_string()
	server.sendmail(fromaddr, toaddr, text)
	server.quit()
	
	
def sendEmailAttach(stkName,file):
	fromaddr = "abc@gmail.com"
	toaddr = "xyz@gmail.com"
	msg = MIMEMultipart()
	msg['From'] = fromaddr
	msg['To'] = toaddr
	msg['Subject'] = "StockUpdates"
	 
	body = 'PFA Stats for %s'%stkName
	msg.attach(MIMEText(body, 'plain'))
	
	filename = file
	attachment = open(file, "rb")
 
	part = MIMEBase('application', 'octet-stream')
	part.set_payload((attachment).read())
	encoders.encode_base64(part)
	part.add_header('Content-Disposition', "attachment; filename= %s" % filename)
 
	msg.attach(part)
	
	server = smtplib.SMTP('smtp.gmail.com', 587)
	server.starttls()
	server.login("abc@gmail.com", "abc")
	text = msg.as_string()
	server.sendmail(fromaddr, toaddr, text)
	server.quit()