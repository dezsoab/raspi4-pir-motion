# raspi4-pir-motion

In this project I am looking for movement with the BL412 PIR Sensor.
On idle the green LED is lit and when motion is detected the red LED is lit.

## demo
you can find a demo video about the running program here:
https://www.youtube.com/shorts/E4AsICq59ds

My circuit looks as following:

![IMG_8355](https://user-images.githubusercontent.com/75616496/207989699-9aa78a23-fa20-43e3-a3f4-2c8a417e243c.jpg)

For the actual data sheet of the product you can visit this page:

https://cdn-shop.adafruit.com/product-files/4667/4667_C15116.pdf

## how to run the program?

navigate to the `src` folder and then run the following command in the terminal:

    mvn clean package

then navigate to the /target folder and run this in the terminal:

    sudo java -jar raspi4-sensor-jar.jar
