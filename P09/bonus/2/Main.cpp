#include "Color.h"

#include <fstream>
#include <string>
#include <ctime>

int main(int argc, char* argv[]) {
	std::ifstream file{argv[1]};

	if(!file) {
		std::cout << "file not found!" << std::endl;
		return 1;
	}

	Color reset{};
	std::string line;

	std::srand(std::time(nullptr));

	while(getline(file, line)) {
		Color color{std::rand() % 255, std::rand() % 255, std::rand() % 255};

		std::cout << color << line << reset << std::endl;
	}

	file.close();
}