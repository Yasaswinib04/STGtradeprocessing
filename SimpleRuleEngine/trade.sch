<?xml version="1.0" encoding="UTF-8"?> 
<schema xmlns="http://purl.oclc.org/dsdl/schematron">
 <pattern id="checkForStructure">
   <rule context="Header">
     <assert test="true()">Header Tag is needed</assert>
     <assert test="./Sender">Sender is mandatory</assert>
   </rule>
    <rule context="Trades"><assert test="true()">Trades tag must  be there</assert></rule>
    <rule context="Trade">


        <let name="SecurityType" value="./CashSecurity/SecurityType"/>
        <let name="SecurityIdentifier" value="./CashSecurity/SecurityIdentifier"/>
        <let name="IndexFlag" value="./IndexFlag"/>
        
      <assert test="true()">Trade tag must  be there</assert>


      <assert test="./TradeId">TradeId is manadatory</assert>
      <assert test="string-length(./TradeId) >= 20">The trade id must be atleast 20 in length</assert>
      <assert test="string-length(translate(./TradeId,'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789',''))=0">The trade id must be alphanumeric
      </assert>


        <assert test="./Firm">Firm is Mandatory</assert>
        <assert test="string-length(./Firm) >= 20">The Firm must be atleast 20 in length</assert>
        <assert test="string-length(translate(./Firm,'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789',''))=0">The Firm must be alphanumeric
        </assert>


        <assert test="./CashSecurity">CashSecurity tag is manadatory</assert>
        <assert test="$SecurityType='EQ' or $SecurityType='CP' or $SecurityType='FX' or $SecurityType='CD' or $SecurityType='OPD'">The CashSecurity must contain one of them [EQ, CP, FX, CD, OPT]</assert>
        <assert test="$SecurityIdentifier">SecurityIdentifier is Mandatory</assert>

        <assert test="not($IndexFlag) or $IndexFlag='Y' or $IndexFlag='N'">Index Field is either optional or Y or N </assert>
      </rule>


      <rule context="//TradeDate">

        <let name="day" value="number(substring(.,1,2))"/>
        <let name="month" value="substring(.,4,2)"/>
        <let name="year" value="number(substring(.,7,4))"/>
        <let name="hour" value="number(substring(.,12,2))"/>
        <let name="minute" value="number(substring(.,15,2))"/>
        <let name="second" value="number(substring(.,18,2))"/>
        <let name="isLeap" value="number((($year mod 4=0) and ($year mod 100!=0)) or ($year mod 400=0))"/>


        <assert test=".">Date is Mandatory</assert>
        
        <assert test="string-length(.)=19 and substring(.,3,1)='-' and substring(.,6,1)='-' and substring(.,11,1)=' ' and substring(.,14,1)=':' and substring(.,17,1)=':'">Date and Time must be in dd-MM-yyyy HH:mm:ss format</assert>

        


        <assert test="$hour>=0 and $hour&lt;=23 and string-length(translate($hour,'0123456789',''))=0">The hour must be a value between 0 and 23.</assert>
        <assert test="$minute>=0 and $minute&lt;=59 and string-length(translate($minute,'0123456789',''))=0">The minutes must be a value between 0 and 59.</assert>
        <assert test="$second>=0 and $second&lt;=59 and string-length(translate($second,'0123456789',''))=0">The second must be a value between 0 and 59.</assert>
        <assert test="$day>0">Date must be greater than 0</assert>
        <report test="$month='02'  and (($isLeap=0 and $day > 28) or ($isLeap=1 and $day >29))">Febuary in non-leap year can't have more than 28 days and in leap year it can have no more than 29 days</report> 
        <report test="($month='01' or $month='03' or $month='05' or $month='07' or $month='08' or $month='10' or $month='12') and day>31">Jan,March,May,July,Aug,oct,dec have no more than 30 days</report>                  
        <report test="($month='04' or $month='06' or $month='09' or $month='11') and $day>30">April,June,Sept,November</report>

       </rule>
  </pattern>
</schema>