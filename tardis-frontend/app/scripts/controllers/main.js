'use strict';

angular.module('NightWhistler.TardisFrontend')

  .controller('MainCtrl', function($scope, $location, version) {

    $scope.$path = $location.path.bind($location);
    $scope.version = version;

  });
