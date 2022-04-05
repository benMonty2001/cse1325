#include "Color.h"

#include <iostream>

int main() {
	Color red{255, 0, 0};
	std::cout << red.colorize("colorized!") << std::endl;
}