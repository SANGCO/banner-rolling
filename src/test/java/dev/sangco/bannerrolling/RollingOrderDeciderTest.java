package dev.sangco.bannerrolling;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RollingOrderDeciderTest {

    @Test
    public void test() {
        List<Banner> banners = new ArrayList<>();

        Banner paramBanner01 = new Banner(1L, 0, 1);
        Banner paramBanner02 = new Banner(2L, 0, 1);
        Banner paramBanner03 = new Banner(3L, 1, 1);
        Banner paramBanner04 = new Banner(4L, 0, 1);
        Banner paramBanner05 = new Banner(5L, 0, 1);
        Banner paramBanner06 = new Banner(6L, 2, 1);
        Banner paramBanner07 = new Banner(7L, 0, 1);
        Banner paramBanner08 = new Banner(8L, 3, 1);
        Banner paramBanner09 = new Banner(9L, 0, 1);
        Banner paramBanner10 = new Banner(10L, 0, 1);

        Banner dbBanner01 = new Banner(1L, 3, 0);
        Banner dbBanner02 = new Banner(2L, 2, 0);
        Banner dbBanner03 = new Banner(3L, 1, 0);
        Banner dbBanner04 = new Banner(4L, 0, 0);
        Banner dbBanner05 = new Banner(5L, 0, 0);
        Banner dbBanner06 = new Banner(6L, 0, 0);
        Banner dbBanner07 = new Banner(7L, 0, 0);
        Banner dbBanner08 = new Banner(8L, 0, 0);
        Banner dbBanner09 = new Banner(9L, 0, 0);
        Banner dbBanner10 = new Banner(10L, 0, 0);

        banners.add(paramBanner01);
        banners.add(paramBanner02);
        banners.add(paramBanner03);
        banners.add(paramBanner04);
        banners.add(paramBanner05);
        banners.add(paramBanner06);
        banners.add(paramBanner07);
        banners.add(paramBanner08);
        banners.add(paramBanner09);
        banners.add(paramBanner10);

        banners.add(dbBanner01);
        banners.add(dbBanner02);
        banners.add(dbBanner03);
        banners.add(dbBanner04);
        banners.add(dbBanner05);
        banners.add(dbBanner06);
        banners.add(dbBanner07);
        banners.add(dbBanner08);
        banners.add(dbBanner09);
        banners.add(dbBanner10);

        List<Banner> result = RollingOrderDecider.decideRollingOrder(banners);
        result.stream().forEach(System.out::println);
    }

}