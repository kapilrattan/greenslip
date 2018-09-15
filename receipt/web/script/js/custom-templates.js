/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var bestPictures = new Bloodhound({
  datumTokenizer: Bloodhound.tokenizers.obj.whitespace('value'),
  queryTokenizer: Bloodhound.tokenizers.whitespace,
  prefetch: '../../data/films/post_1960.json',
  remote: {
    url: '../data/films/queries/%QUERY.json',
    wildcard: '%QUERY'
  }
});

$('#custom-templates .typeahead').typeahead(null, {
  name: 'best-pictures',
  display: 'value',
  source: bestPictures,
  templates: {
    empty: [
      '<div class="empty-message">',
        'unable to find any Best Picture winners that match the current query',
      '</div>'
    ].join('\n'),
    suggestion: Handlebars.compile('<div><strong>{{value}}</strong> – {{year}}</div>')
  }
});