# Block Runner

A Minecraft mod. Downloads can be found on [CurseForge](https://www.curseforge.com/members/fuzs_/projects) and [Modrinth](https://modrinth.com/user/Fuzs).

![](https://raw.githubusercontent.com/Fuzss/modresources/main/pages/data/blockrunner/banner.png)

## Configuration (1.21+)
Block Runner uses a block [data map](https://docs.neoforged.net/docs/resources/server/datamaps/) registered at `blockrunner:block_speeds` for defining block speeds. The data values consist of a single `speed` key paired with a double value, with `1.0` being the default block speed. 

Data maps are available on Fabric as well, provided by the bundled [NeoForge Data Pack Extensions](https://github.com/Fuzss/neoforgedatapackextensions) library.

**Example:** `data/blockrunner/data_maps/block/block_speeds.json`
```json5
{
  "values": {
    "minecraft:dirt_path": {
      "speed": 1.35
    }
  }
}
```

To aid other mod developers who wish to use Block Runners capabilities, a few block tags with default speed values are included. Those can easily be used by other modders to add support without providing their own data map.
- `blockrunner:very_slow_blocks`: 0.45
- `blockrunner:slow_blocks`: 0.65
- `blockrunner:slightly_slow_blocks`: 0.85
- `blockrunner:slightly_quick_blocks`: 1.15
- `blockrunner:quick_blocks`: 1.35
- `blockrunner:very_quick_blocks`: 1.55
