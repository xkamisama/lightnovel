/*!
 * jQuery Cropper v1.0.0-beta
 * https://github.com/fengyuanchen/jquery-cropper
 *
 * Copyright (c) 2018 Chen Fengyuan
 * Released under the MIT license
 *
 * Date: 2018-03-03T04:12:17.906Z
 */

import $ from 'jquery';
import Cropper from 'cropperjs';

if ($.fn) {
  var AnotherCropper = $.fn.cropper;
  var NAMESPACE = 'cropper';

  $.fn.cropper = function jQueryCropper(option) {
    for (var _len = arguments.length, args = Array(_len > 1 ? _len - 1 : 0), _key = 1; _key < _len; _key++) {
      args[_key - 1] = arguments[_key];
    }

    var result = void 0;

    this.each(function (i, element) {
      var $element = $(element);
      var isDestroy = option === 'destroy';
      var cropper = $element.data(NAMESPACE);

      if (!cropper) {
        if (isDestroy) {
          return;
        }

        var options = $.extend({}, $element.data(), $.isPlainObject(option) && option);

        cropper = new Cropper(element, options);
        $element.data(NAMESPACE, cropper);
      }

      if (typeof option === 'string') {
        var fn = cropper[option];

        if ($.isFunction(fn)) {
          result = fn.apply(cropper, args);

          if (result === cropper) {
            result = undefined;
          }

          if (isDestroy) {
            $element.removeData(NAMESPACE);
          }
        }
      }
    });

    return typeof result === 'undefined' ? this : result;
  };

  $.fn.cropper.Constructor = Cropper;
  $.fn.cropper.setDefaults = Cropper.setDefaults;
  $.fn.cropper.noConflict = function noConflict() {
    $.fn.cropper = AnotherCropper;
    return this;
  };
}
