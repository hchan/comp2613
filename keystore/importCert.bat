keytool -storepass password -v -trustcacerts -keystore startrekvancouver.jks -importcert -alias myalias -file startrekvancouver.pem 

@rem keytool -import -alias root -file CACertSigningAuthority.pem -keystore startrekvancouver.jks -storepass password -v -trustcacerts

@REM if you get java.lang.Exception: Failed to establish chain from reply, try using a new alias, one that doesn't exist
