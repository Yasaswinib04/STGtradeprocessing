# -*- coding: utf-8 -*-

import glob
from lxml import etree
from lxml.isoschematron import Schematron
import time

def fun():
   path="Trades/*.xml"
   files=glob.glob(path) 
  # print(files)
   for file in files:
       xml_file = etree.parse(file)
       xml_validator =Schematron(file="trade.sch")
       is_valid = xml_validator.validate(xml_file)
       print(is_valid)
      # report = xml_validator.validation_report
     #  print(type(report))
     #  print(report)
 

start = time.time()      
fun()
end = time.time()
print(end-start)


#--------------------------------------------------------------      
 
#sum=0;
#for i in range(100):
    
    
#    sum+=((end - start)/11)
   #xml_validator =Schematron(file="trade.sch",store_report=True)  
#print(sum/100)