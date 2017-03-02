start javaw -DworkingDir="%~dp0\" ^
		-Dlog4j.configuration="file:%~dp0resources\log4j.properties" ^
		-cp "%~dp0lib\*;%~dp0BizapediaExtractor.jar" ^
		org.malibu.msu.bizapedia.ui.BizapediaExtractorUi