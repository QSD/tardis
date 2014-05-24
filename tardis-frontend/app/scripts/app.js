'use strict';

console.log("App.js");

var tardisApp = angular.module('QSD.Tardis', ['ngAnimate', 'ngResource', 'ngRoute', 'restangular'])

  .constant('version', 'v0.1.0')

  .config(function($locationProvider, $routeProvider) {

    console.log( "Inside app.js");

    $locationProvider.html5Mode(false);

    $routeProvider
      .when('/', {
        templateUrl: 'views/home.html'
      })
      .when('/features', {
        templateUrl: 'views/features.html'
      })
      .when('/contact', {
        templateUrl: 'views/contact.html'
      })
      .otherwise({
        redirectTo: '/'
      });

  });

