javac -d bin -sourcepath src -cp lib/httpclient-4.3.3.jar:lib/httpclient-cache-4.3.3.jar:lib/httpcore-4.3.2.jar:lib/httpmime-4.3.3.jar:lib/commons-codec-1.6.jar:lib/commons-logging-1.1.3.jar:lib/commons-validator-1.4.0.jar:lib/commons-validator-1.4.0.jar src/HtmlDownloader.java

javac -d bin -sourcepath test -cp  bin:lib/httpclient-4.3.3.jar:lib/httpclient-cache-4.3.3.jar:lib/httpcore-4.3.2.jar:lib/httpmime-4.3.3.jar:lib/commons-codec-1.6.jar:lib/commons-logging-1.1.3.jar:lib/commons-validator-1.4.0.jar:lib/jsoup-1.7.3.jar:lib/commons-validator-1.4.0.jar test/HtmlDownloaderTest.java

java -cp bin:lib/httpclient-4.3.3.jar:lib/httpclient-cache-4.3.3.jar:lib/httpcore-4.3.2.jar:lib/httpmime-4.3.3.jar:lib/httpcore-4.3.2.jar:lib/httpmime-4.3.3.jar:lib/commons-codec-1.6.jar:lib/commons-logging-1.1.3.jar:lib/commons-validator-1.4.0.jar:lib/commons-validator-1.4.0.jar HtmlDownloaderTest

HtmlDownloaderTest
javac -d bin -sourcepath test -cp  bin:lib/httpclient-4.3.3.jar:lib/httpclient-cache-4.3.3.jar:lib/httpcore-4.3.2.jar:lib/httpmime-4.3.3.jar:lib/commons-codec-1.6.jar:lib/commons-logging-1.1.3.jar:lib/commons-validator-1.4.0.jar:lib/Googlebot.jar test/HtmlDownloaderTest.java

java -cp bin:lib/httpclient-4.3.3.jar:lib/httpclient-cache-4.3.3.jar:lib/httpcore-4.3.2.jar:lib/httpmime-4.3.3.jar:lib/httpcore-4.3.2.jar:lib/httpmime-4.3.3.jar:lib/commons-codec-1.6.jar:lib/commons-logging-1.1.3.jar:lib/commons-validator-1.4.0.jar:lib/Googlebot.jar HtmlDownloaderTest
