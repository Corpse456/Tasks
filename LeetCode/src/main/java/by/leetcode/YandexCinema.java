package by.leetcode;

/**
 *  Места в кинотеатре расположены в один ряд. Только что пришедший зритель выбирает место,
 * чтобы сидеть максимально далеко от остальных зрителей в ряду.
 * То есть расстояние от того места, куда сядет зритель до ближайшего к нему зрителя
 * должно быть максимально.
 *
 * Гарантируется, что в ряду всегда есть свободные места и уже сидит хотя бы один зритель.
 *
 * Напишите функцию, которая по заданному ряду мест (массиву из нулей и единиц)
 * вернёт расстояние (ЧИСЛО ПОДЛОКОТНИКОВ) от выбранного места до ближайшего зрителя.
 */
public class YandexCinema {

    public int findBestSeatDist(int[] seats) {
        int maxElbow = 0;
        int currentElbow = 0;
        boolean hasPrevious = false;
        for (final int seat : seats) {
            if (seat == 0) {
                currentElbow++;
            } else {
                maxElbow = hasPrevious
                        ? Math.max(maxElbow, (currentElbow / 2) + (currentElbow % 2))
                        : Math.max(maxElbow, currentElbow);
                currentElbow = 0;
                hasPrevious = true;
            }
        }
        return Math.max(maxElbow, currentElbow);
    }
}
