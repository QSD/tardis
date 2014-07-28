[![Stories in Ready](https://badge.waffle.io/qsd/tardis.png?label=ready&title=Ready)](https://waffle.io/qsd/tardis)

#Tardis

## Mission

Monitor the entire lifecycle of your software, analyze different sources and
find interesting connections between events.

## Global information

* Board, is on [Waffle](https://waffle.io/)
* [Client README](./tardis/tardis-frontend/README.md)

## Events

Events are really basic. Send using REST (PUT's) and are in [JSON](http://json.org)
format. The following structure is used:

    {
        "event": {
            "metadata": {
                "timestamp": 223923429,
                "source": "some application name"
        },
            "data": "VGhpcyBpcyB0aGUgY29udGVudC4uLg=="
        }
    }

## TODO
* add to travis.ci
* improve documentation
