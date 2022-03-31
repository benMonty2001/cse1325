#include <iostream>
#include <vector>
#include <algorithm>

int main() {
	std::vector<std::string> lines;
	std::string current_line;

	while(std::getline(std::cin, current_line)) {
		lines.push_back(current_line);
	}

	std::sort(lines.begin(), lines.end());

	std::cout << std::endl;

	for(auto s : lines) {
		std::cout << s << std::endl;
	}
}