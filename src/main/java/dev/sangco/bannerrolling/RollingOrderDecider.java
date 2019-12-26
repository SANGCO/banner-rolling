package dev.sangco.bannerrolling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RollingOrderDecider {

    public static List<Banner> decideRollingOrder(List<Banner> beforeHandleBanners) {
        Map<Long, Banner> afterHandleBanners = new HashMap<>();
        Map<Integer, Banner> bannerMap = new HashMap<>();

        for (Banner beforeHandleBanner : beforeHandleBanners) {
            int order = beforeHandleBanner.getOrder();
            if (order == 0)
                continue;

            Banner banner = bannerMap.get(order);
            if (banner == null) {
                bannerMap.put(order, beforeHandleBanner);
                setResult(afterHandleBanners, beforeHandleBanner);
                continue;
            }

            if (banner.getPriority() == beforeHandleBanner.getPriority()) {
                throw new RuntimeException("순서 중복 발생");
            }
            if (banner.getPriority() > beforeHandleBanner.getPriority()) {
                beforeHandleBanner.setOrder(0);
                setResult(afterHandleBanners, beforeHandleBanner);
            }
            if (banner.getPriority() < beforeHandleBanner.getPriority()) {
                bannerMap.remove(banner.getOrder());
                banner.setOrder(0);
                setResult(afterHandleBanners, banner);
                bannerMap.put(order, beforeHandleBanner);
                setResult(afterHandleBanners, beforeHandleBanner);
            }
        }

        if (bannerMap.size() < 1)
            throw new RuntimeException("최소 1개");
        if (bannerMap.size() > 3)
            throw new RuntimeException("최대 3개");

        return new ArrayList<>(afterHandleBanners.values());
    }

    private static void setResult(Map<Long, Banner> afterHandleBanners, Banner beforeHandleBanner) {
        Banner banner = afterHandleBanners.get(beforeHandleBanner.getId());
        if (banner != null && banner.getPriority() < beforeHandleBanner.getPriority()) {
            afterHandleBanners.put(beforeHandleBanner.getId(), beforeHandleBanner);
        }

        afterHandleBanners.putIfAbsent(beforeHandleBanner.getId(), beforeHandleBanner);
    }
}
