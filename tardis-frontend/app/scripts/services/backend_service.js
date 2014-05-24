'use strict';
angular.module('QSD.Tardis')

    .factory('backendService', ['Restangular', function(Restangular) {

        console.log("Creating backendService");

        var url = 'status/all';

        var getLights = function() {
           return Restangular.allUrl( '/status/all', 'http://localhost:8080/status/all' ).getList();
        }

        return {
            getLights: getLights
        }


   }]);

  
