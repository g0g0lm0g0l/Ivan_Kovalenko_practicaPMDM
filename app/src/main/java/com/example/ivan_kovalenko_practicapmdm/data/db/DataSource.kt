package com.example.ivan_kovalenko_practicapmdm.data.db

import com.example.ivan_kovalenko_practicapmdm.data.db.model.Article

class NewsDataSource {
    companion object {
        val articles = listOf(
            Article(
                author = "By <a href=\"/profiles/jessie-yeung\">Jessie Yeung</a>, Antoinette Radford, Sophie Tanno and Amarachi Orie, CNN",
                content = "Israeli Prime Minister Benjamin Netanyahu defended his policies in the Gaza Strip after US President Joe Biden said the Israeli leader is \"hurting Israel more than helping.\" \"I don't know exactly wh… [+1819 chars]",
                title = "Devastation in Gaza as Israel wages war on Hamas: Live updates - CNN",
                url = "https://www.cnn.com/middleeast/live-news/israel-hamas-war-gaza-news-03-10-24/index.html",
                urlToImage = "https://cdn.cnn.com/cnnnext/dam/assets/240308125758-israel-gaza-live-news-030824-super-tease.jpg"
            ),
            Article(
                author = null,
                content = "Mar 10, 2024, 05:12 PM ET\r\nThe Tampa Bay Buccaneers and quarterback Baker Mayfield agreed to a three-year deal for $100 million in total and $50 million guaranteed, sources told ESPN on Sunday.\r\nMayf… [+3782 chars]",
                title = "Sources: Buccaneers, Baker Mayfield agree on 3-year, $100M deal - ESPN",
                url = "https://www.espn.com/nfl/story/_/id/39702094/source-buccaneers-baker-mayfield-agree-3-year-100m-deal",
                urlToImage = "https://a2.espncdn.com/combiner/i?img=%2Fphoto%2F2023%2F0913%2Fr1224085_1296x729_16%2D9.jpg"
            ),
            Article(
                author = "Sarah Min",
                content = "U.S. stock futures fell slightly Sunday night after the Dow Jones Industrial Average closed out its worst week since October. Investors are also looking ahead to inflation data due out later this wee… [+1863 chars]",
                title = "Stock futures are little changed after Dow's worst week since October: Live updates - CNBC",
                url = "https://www.cnbc.com/2024/03/10/stock-market-today-live-updates.html",
                urlToImage = "https://image.cnbcfm.com/api/v1/image/107380440-17092234142024-02-29t161013z_1576352246_rc2ec6ac487f_rtrmadp_0_usa-stocks.jpeg?v=1709223462&w=1920&h=1080"
            ),
            Article(
                author = "Amy Or",
                content = "(Bloomberg) -- Reddit Inc. and its investors are seeking to raise as much as $748 million in what would be one of the biggest initial public offerings so far this year, according to people familiar w… [+5697 chars]",
                title = "Reddit's Planned IPO to Seek Up to $748 Million - Yahoo Finance",
                url = "https://finance.yahoo.com/news/reddit-planned-ipo-seek-748-191215835.html",
                urlToImage = "https://s.yimg.com/ny/api/res/1.2/F4HaV8YDkunMO13JUdPc9g--/YXBwaWQ9aGlnaGxhbmRlcjt3PTEyMDA7aD04MDE-/https://media.zenfs.com/en/bloomberg_markets_842/0cfb422247686ca1a41bf6e3d5a04af9"
            ),
            Article(
                author = null,
                content = null,
                title = "Haiti: US evacuates embassy staff amid gang violence - BBC.com",
                url = "https://www.bbc.com/news/world-latin-america-68528839",
                urlToImage = "https://ichef.bbci.co.uk/news/1024/branded_news/02CE/production/_132881700_mediaitem132881699.jpg"
            ),
            Article(
                author = "Victoria Hernandez",
                content = "Top-ranked South Carolina beat No. 5 LSU 79-72 to win Dawn Staleys eighth SEC championship in 10 years on Sunday at Bon Secours Wellness Arena in Greenville, South Carolina. It was a tense matchup ag… [+10510 chars]",
                title = "Live: South Carolina beats LSU for women's SEC championship after near-brawl, ejections - USA TODAY",
                url = "https://www.usatoday.com/story/sports/ncaaw/sec/2024/03/10/angel-reese-walking-boot-sec-title-game-south-carolina/72922679007/",
                urlToImage = "https://www.usatoday.com/gcdn/authoring/authoring-images/2024/03/10/USAT/72923628007-ap-sec-lsu-south-carolina-basketball.jpg?crop=3042,1712,x0,y158&width=3042&height=1712&format=pjpg&auto=webp"
            ),
            Article(
                author = "Lisa Respers France",
                content = "Its finally here the 96th Academy Awards are about to be underway at the Dolby Theater in the heart of Hollywood. The telecast is starting at the new time of 7 p.m. ET on ABC. (Yes, one hour earlier.)… [+3514 chars]",
                title = "Academy Award winners 2024: See who took home the Oscar - CNN",
                url = "https://www.cnn.com/2024/03/10/entertainment/award-winners-list-oscars-nominees/index.html",
                urlToImage = "https://media.cnn.com/api/v1/images/stellar/prod/130110124813-oscar-tease.jpg?c=16x9&q=w_800,c_fill"
            )
        )

        fun getNews(): List<Article> {
            return articles
        }

    }
}