## DAT250: Software Technology Experiment Assignment 3

### Experiment 1:

I went through the interactive mongodb web tutorial.
Then I downloaded MongoDB4.4 installer and verified the checksum:

![img.png](Images/checksumValidation.png)

The checksum matched, so I installed the software and set it up as a Windows service.


Then I downloaded MongoShell and added it to PATH.

I went through all the CRUD operations and did the examples:

![img.png](Images/img0.png)

![img.png](Images/img1.png)

![img.png](Images/img.png)

![img_1.png](Images/img2.png)

### Experiment 2:
I added the customer data from the Map Reduce example:

![img.png](Images/customerData.png)

Map reduce example of sum of products bought per customer:

![img.png](Images/mapReduce.png)

Map reduce that calculates the average price of items bought per customer.
I defined a new mapFunction to extract the price of each product (ignoring the quantity) and taking the average of the array in the reduceFunction.

![img.png](Images/mapReduce2.png)

Average of items with counting quantity:

![img.png](Images/mapReduce2b.png)

This map reduce function might be useful for a quick customer analysis. 
It might indicate what type of people are shopping, given by the price-point of which that they are buying things at.
I also made this example so that I could experiment with using and extracting 'deeper' JSON list variables.

### Issues:
- The mapReduce function is not working when used inside the Mongodb Compass console. I got it to finally work by using 'mongosh' in a cmd shell instead.