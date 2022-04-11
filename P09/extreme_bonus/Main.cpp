#include "Color.h"

int main() {

	try {
		Color red{255, 0, 0};
		Color green{0, 255, 0};
		Color blue{0, 0, 255};
		Color reset{};
		
		Color purple = red + blue;
		std::cout << purple << "purple!" << Color::RESET << std::endl;

		Color dark_green = green - 100;
		std::cout << dark_green << "dark green!" << Color::RESET << std::endl;

	} catch(const std::invalid_argument& e) {
		std::cout << e.what() << std::endl;
	}
}