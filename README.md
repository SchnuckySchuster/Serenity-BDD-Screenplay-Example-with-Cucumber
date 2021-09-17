# Serenity-BDD-Screenplay-Example-with-Cucumber

This project exists to demonstrate specific aspects of Serenity.

## Taking screenshots

After updating to a newer Serenity version I could no longer take full page screenshots.
This is the demonstrator for my calamity.

## Starting point

I have a nice test suite where I'm using Serenity 2.4.4.

I use following configuration in order to take full screen screenshots and it works fine.

```    
    serenity.full.page.screenshot.strategy = true
```

Now I want to update to the latest version and there the problems start.

## Update to the newest version

### Old WebDriver screenshot config

With the newest Serenity Version this

```    
    serenity.full.page.screenshot.strategy = true
```

does not take full page screen shots any longer.

### Shuterbug 0.9.5

With the settings given in the manual
```    
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-shutterbug</artifactId>
            <version>${serenity.version}</version>
        </dependency>
        
        serernity.screenshooter = shutterbug

        shutterbug {
            #scrollstrategy = VIEWPORT_ONLY (or) WHOLE_PAGE (or) WHOLE_PAGE_SCROLL_AND_STITCH
            scrollstrategy = WHOLE_PAGE
            betweenScrollTimeout = 100
            useDevicePixelRatio = true
        }
```    
I see full page screenshots, but

- The settings WHOLE_PAGE (or) WHOLE_PAGE_SCROLL_AND_STITCH both behave the same
- It takes ages to take the screenshots, meaning it is possible but not feasible to take full page screenshots with shutterbug 0.9.5

### Shuterbug 1.5

With the settings given in the manual
```    
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-shutterbug1x</artifactId>
            <version>${serenity.version}</version>
        </dependency>
        
        serernity.screenshooter = shutterbug1x

        shutterbug {
            #capturestrategy = VIEWPORT (or) FULL (or) FULL_SCROLL (or) VERTICAL_SCROLL (or) HORIZONTAL_SCROLL
            capturestrategy = FULL_SCROLL
            betweenScrollTimeout = 100
            useDevicePixelRatio = true
        }
```    
I'm not able to create full page screenshots. It looks like the parameter 'capturestrategy' takes no effect. 
