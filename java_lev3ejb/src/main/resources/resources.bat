echo Creating resources

rem Properties
asadmin delete-custom-resource myParams
asadmin create-custom-resource --restype=java.util.Properties --factoryclass=org.glassfish.resources.custom.factory.PropertiesFactory --property "param1=\"this is param1\":param2=\"this is param2\"" myParams

rem String
asadmin delete-custom-resource resource/myUrl
asadmin create-custom-resource --restype=java.lang.String --factoryclass=org.glassfish.resources.custom.factory.PrimitivesAndStringFactory --property value="http\://www.yandex.ru" resource/myUrl

rem Double
asadmin delete-custom-resource resource/myRate
asadmin create-custom-resource --restype=java.lang.Double --factoryclass=org.glassfish.resources.custom.factory.PrimitivesAndStringFactory --property value=33.13 resource/myRate

asadmin list-custom-resources
