# from __future__ import print_function
from random import randrange
from time import sleep
import datetime


print "Opening writer to disk "

location = '/data/file'
formatter = "%r %r %r"
f = open(location,'w')

print "start writing to ", location, " on ", datetime.datetime.now()
while True:
    # make this a nice function
    f.write("{time} Testing {number}\n".format(
        number=randrange(10),
        time=datetime.datetime.now()
    ))
    # )
    sleep(0.02) # Time in seconds.


print "... done writing. Existing "
