.DEFAULT_GOAL:=help
SHELL:=/bin/bash

##@ Dependencies

.PHONY: dependencies

dependencies:  ## Check dependencies. Detect unused or misused dependencies and determine which dependencies have updates
	./gradlew dependencyUpdates\
			  buildHealth\
              dependencyCheckAggregate

##@ Documentation

.PHONY: documentation

documentation:  ## Generate HTML documentation for all modules
	./gradlew clean\
              dokkaHtmlMultiModule

##@ Coverage

.PHONY: coverage

coverage:  ## Generates code coverage HTML and XML reports for all modules
	./gradlew koverMergedReport

##@ Cleanup

.PHONY: autocorrect

autocorrect:  ## Applies code formatting steps to sourcecode in-place
	./gradlew spotlessApply

.PHONY: detekt_baseline

detekt_baseline:  ## Update Detekt baseline files
	./gradlew detektBaseline\
			  detektBaselineMain

##@ Building

all:   ## Run documentation -> dependencies -> build
	make documentation\
         dependencies\
         build

check:   ## Check code style and format
	./gradlew check\
         spotlessCheck\
         detektMain

.PHONY: build

build:  ## Build
	./gradlew spotlessCheck\
			  detektMain\
			  build

##@ Helpers

.PHONY: help

help:  ## Display this help
	@awk 'BEGIN {FS = ":.*##"; printf "\nUsage:\n  make \033[36m<target>\033[0m\n"} /^[a-zA-Z_-]+:.*?##/ { printf "  \033[36m%-15s\033[0m %s\n", $$1, $$2 } /^##@/ { printf "\n\033[1m%s\033[0m\n", substr($$0, 5) } ' $(MAKEFILE_LIST)
