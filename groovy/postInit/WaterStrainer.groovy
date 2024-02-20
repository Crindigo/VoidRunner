def removals = ['net', 'net_1', 'strainer_base',
    'strainer_survivalist_solid', 'strainer_survivalist_dense_solid',
    'strainer_survivalist_reinforced', 'strainer_survivalist_dense_reinforced',
];
for ( removal in removals ) {
    crafting.remove("waterstrainer:$removal");
}

// Rework mesh recipes to allow for twine instead of just string

crafting.shapedBuilder()
    .name('strainer_net')
    .output(item('waterstrainer:net', 0))
    .shape('ttt')
    .key('t', ore('twine'))
    .register();

crafting.shapedBuilder()
    .name('strainer_net_dense')
    .output(item('waterstrainer:net', 1) * 2)
    .shape('ttt', 'ttt')
    .key('t', ore('twine'))
    .register();

// Remove hopper and iron bars from strainer base recipe
crafting.shapedBuilder()
    .name('strainer_base')
    .output(item('waterstrainer:strainer_base'))
    .shape('f f', 'plp', 'pcp')
    .key('f', ore('fenceWood'))
    .key('p', ore('plankWood'))
    .key('l', ore('logWood'))
    .key('c', ore('chestWood'))
    .register();

// Tier 2 strainers

crafting.shapedBuilder()
    .name('strainer_solid')
    .output(item('waterstrainer:strainer_survivalist_solid'))
    .shape('rrr', 'rnr', 'rrr')
    .key('r', ore('stickIron'))
    .key('n', item('waterstrainer:net', 0))
    .register();

crafting.shapedBuilder()
    .name('strainer_dense_solid')
    .output(item('waterstrainer:strainer_survivalist_dense_solid'))
    .shape('rrr', 'rnr', 'rrr')
    .key('r', ore('stickIron'))
    .key('n', item('waterstrainer:net', 1))
    .register();
    

// Tier 3
// _reinforced, _dense_reinforced
crafting.shapedBuilder()
    .name('strainer_reinforced')
    .output(item('waterstrainer:strainer_survivalist_reinforced'))
    .shape('rsr', 'sns', 'rsr')
    .key('r', ore('plateSteel'))
    .key('s', ore('platePotin'))
    .key('n', item('waterstrainer:net', 0))
    .register();

crafting.shapedBuilder()
    .name('strainer_dense_reinforced')
    .output(item('waterstrainer:strainer_survivalist_dense_reinforced'))
    .shape('rsr', 'sns', 'rsr')
    .key('r', ore('plateSteel'))
    .key('s', ore('platePotin'))
    .key('n', item('waterstrainer:net', 1))
    .register();