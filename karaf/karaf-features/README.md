# Usage

0. start karaf
1. mvn clean install(in parent directory)
2. feature:repo-add mvn:com.chf/karaf-features/0.0.1-SNAPSHOT/xml
3. feature:install karaf-example

* use cxf feature, feature:repo-add cxf and visit host:port/cxf/path
