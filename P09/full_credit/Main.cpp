#include "Color.h"

#include <iostream>

int main() {
	Color red{255, 0, 0};
	Color green{0, 255, 0};
	Color blue{0, 0, 255};

	std::cout << red.colorize("Red") << std::endl;
	std::cout << green.colorize("Green") << std::endl;
	std::cout << blue.colorize("Blue") << std::endl;

	int in_red, in_green, in_blue;

	std::cout << "Enter red, green, blue ints: ";
	
	std::cin >> in_red;
	std::cin >> in_green; 
	std::cin >> in_blue;  

	Color custom{in_red, in_green, in_blue};

	std::cout << custom.colorize(custom.to_string()) << std::endl;
}