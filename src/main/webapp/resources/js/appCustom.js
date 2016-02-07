function ajaxTemplate(url, divId) {
    jQuery.ajax({
        url: url
    }).done(function (data) {
        jQuery("#" + divId).html(data);
    }).fail(function () {
        console.log("Ajax Failed");
    });
}

function ajaxTemplateForSave(url, divId, data) {
    jQuery.ajax({
        url: url,
        data: data
    }).done(function (data) {
        jQuery("#" + divId).html(data);
    }).fail(function () {
        console.log("Ajax Failed");
    });
}

function updateTopic(topicId) {
    var data = {id: topicId};
    ajaxTemplateForSave("/topic/update", "right-side-panel", data);
}
