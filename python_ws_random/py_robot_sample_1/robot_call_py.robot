*** Settings ***
Library         SeleniumLibrary
Library         my_math.py
#Suite Setup     ChromeSetupForBoostTouchEvents
#Suite Teardown  Close Browser

*** Test Cases ***
Run function add
	Run python def function add
	Main

Run class function add
	click element	//*[@id='pricebtn']
	Sleep	5

*** Keywords ***
Run python def function add
    add    2   4
