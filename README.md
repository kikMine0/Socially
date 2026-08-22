# Socially
Add your socials to your server.

## How to use
Everything is in the **config.yml**, from there, you can add as many entries you want
Here's an example:
```YAML
socials:  
  example: # This will become a command, once you reload/restart your server
    - "This is message &c#1"  # You can use Legacy formatting
    - "<click:open_url:'http://i-am-an.url'>This is message #2</click>" # Or use MiniMessage
```
After doing all the changes, run the command 
`/socially reload`

And you should be all good!

## What is available
|  | Is supported? | 
| ----------- | :-: |
| **MiniMessage** | ✅ |
| **Legacy Formatting** | ✅ |
| **PlaceholderAPI** | ❌ |

PlaceholderAPI support is planned in future releases.
