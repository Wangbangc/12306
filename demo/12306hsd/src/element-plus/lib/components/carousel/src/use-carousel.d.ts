import type { SetupContext } from 'vue';
import type { CarouselItemContext } from './constants';
import type { CarouselEmits, CarouselProps } from './carousel';
export declare const useCarousel: (props: CarouselProps, emit: SetupContext<CarouselEmits>['emit'], componentName: string) => {
    root: import("vue").Ref<HTMLDivElement | undefined>;
    activeIndex: import("vue").Ref<number>;
    arrowDisplay: import("vue").ComputedRef<boolean>;
    hasLabel: import("vue").ComputedRef<boolean>;
    hover: import("vue").Ref<boolean>;
    isCardType: import("vue").ComputedRef<boolean>;
    items: import("vue").ShallowRef<CarouselItemContext[]>;
    isVertical: import("vue").ComputedRef<boolean>;
    containerStyle: import("vue").ComputedRef<{
        height: string;
        overflow?: undefined;
    } | {
        height: string;
        overflow: string;
    }>;
    handleButtonEnter: (arrow: 'left' | 'right') => void;
    handleButtonLeave: () => void;
    handleIndicatorClick: (index: number) => void;
    handleMouseEnter: () => void;
    handleMouseLeave: () => void;
    setActiveItem: (index: number | string) => void;
    prev: () => void;
    next: () => void;
    throttledArrowClick: import("lodash").DebouncedFunc<(index: number) => void>;
    throttledIndicatorHover: import("lodash").DebouncedFunc<(index: number) => void>;
};
